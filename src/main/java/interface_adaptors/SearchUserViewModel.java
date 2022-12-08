package interface_adaptors;

import abr.search_engine_abr.SearchSongAbr;
import abr.search_engine_abr.SongLibrary;
import ds.user_search_engine.SearchEngineFileGateway;
import entities.Song;
import entities.user_entities.User;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

/**
 * @author Zhaolang05
 * @date 2022/12/07/22:00
 */
public class SearchUserViewModel extends JFrame implements ActionListener {


    //Operation panel, storage search,ok buttons
    private JPanel controlPanel;
    //Define the data model for the table
    private DefaultTableModel model;
    //Define a table
    private JTable table;
    //Defines a scroll panel to place the table
    private JScrollPane scrollPane;
    //search ok button,input search text
    private JButton searchBtn;
    private JButton okBtn;
    private JLabel Jl1 = new JLabel("Search song name：");
    private JTextField jt1 = new JTextField(20);
    private SearchEngineFileGateway userDao = new SearchEngineFileGateway();
    public SearchUserViewModel() throws HeadlessException {
        //表头
        Vector vectorName = new Vector();
        vectorName.add("User ID");
        vectorName.add("User Name");
        vectorName.add("Friend List");

        //Initialize the data and load all the users
        Vector vectorData = new Vector();
        User [] users = userDao.getUserArray();

        for (User user : users) {
            Vector vdata = new Vector();
            vdata.add(user.getUserID());
            vdata.add(user.getUserName());
            vdata.add(user.getFriendList());
            vectorData.add(vdata);

        }
        //Initialize the table data model
        model = new DefaultTableModel(vectorData, vectorName);
        //Initialize the table with a tabular model
        table = new JTable(model);
        //Initialize the scroll panel
        scrollPane = new JScrollPane(table);
        //Initialize button
        searchBtn = new JButton("Search");
        okBtn = new JButton("OK");

        //Add a listening event to the button
        searchBtn.addActionListener(this);
        okBtn.addActionListener(this);
        //Initialize the control panel and add the  buttons
        controlPanel = new JPanel();
        controlPanel.add(Jl1);
        controlPanel.add(jt1);

        controlPanel.add(searchBtn);
        controlPanel.add(okBtn);
        //Set the panel layout, control buttons on top, and put a list of tables in the middle
        add(controlPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        //Set the alignment in the table
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        //Gets the column object of the table by column name and applies the alignment set above to the specified column
        table.getColumn("User ID").setCellRenderer(renderer);
        table.getColumn("Friend List").setCellRenderer(renderer);

        //Set the table width, as well as the maximum and minimum width of the drag
        DefaultTableColumnModel dcm = (DefaultTableColumnModel) table.getColumnModel();
        dcm.getColumn(0).setPreferredWidth(320);
        dcm.getColumn(0).setMinWidth(45);
        dcm.getColumn(0).setMaxWidth(320);
        //Set the row height
        table.setRowHeight(20);

        //mouse listening events
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                int col = table.getSelectedColumn();
                System.out.println("selected=>" + table.getValueAt(row, col));
            }
        });
        //The tabular data model listens for events
        table.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                System.out.println("Tabular model events e=>" + e);
                if (e.getType() == TableModelEvent.UPDATE) {
                    int row = table.getSelectedRow();
                    int col = table.getSelectedColumn();
                    System.out.println("After modification=>" + table.getValueAt(row, col));
                }
            }
        });
        //Allows clicking on JTable's header to sort up, down
        table.setAutoCreateRowSorter(true);

        //setBounds(100,100,600,400);
        setSize(600, 400);
        //Center the window
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //set to visible, when the dialog window pops up later, you may need to put it into other functions

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchBtn) {
            User[] users = userDao.getUserArray();
            Vector vectorName = new Vector();
            vectorName.add("User ID");
            vectorName.add("User Name");
            vectorName.add("Friend List");
            //Initialize the data

            Vector vectorData = new Vector();


            for (User user : users) {
                Vector vdata = new Vector();
                vdata.add(user.getUserID());
                vdata.add(user.getUserName());
                vdata.add(user.getFriendList());
                vectorData.add(vdata);
            }
            model = new DefaultTableModel(vectorData, vectorName);
            table.setModel(model);
            scrollPane.setViewportView(table);
        } else if (e.getSource() == okBtn) {
            int i = table.getSelectedRow();
            if (i == -1) {
                JOptionPane.showMessageDialog(this, "Please select a record");
                return;
            }
            //close and return
        }

    }

    public static void main(String[] args) {
        new SearchUserViewModel();
    }


}


