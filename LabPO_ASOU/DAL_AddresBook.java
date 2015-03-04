package LabPO_ASOU;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Дмитрий on 22.02.2015.
 */
public class DAL_AddresBook {
    static List<Address_6_2> data = new ArrayList<Address_6_2>();
    public DAL_AddresBook(){
        WR_XML wrXml = new WR_XML();
        data = wrXml.readXML();
    }

    public void  saveAndExit(){
        WR_XML writeXMLFile = new WR_XML();
        writeXMLFile.writeXML(data, data.size());
        System.exit(0);
    }

    public  List <Address_6_2> printAllNode(){
        return data;
    }

    public void add (Address_6_2 newEntry){
        data.add(newEntry);
    }

    public void delete(int index){
        data.remove(index);
    }

    public void change (Address_6_2 newDate, int index){
        data.set(index, newDate);
    }

    public List <Address_6_2> searchName(String name){
        List <Address_6_2> searchDate = new ArrayList<Address_6_2>();

        for (int i = 0; i < data.size(); i++ ) {
            if (data.get(i).getName().toString().equals(name)) {
                searchDate.add(data.get(i));
            }
        }
        return searchDate;
    }

    public List <Integer> searchName(String name, int nam){
        List <Integer> searchDate = new ArrayList<Integer>();

        for (int i = 0; i < data.size(); i++ ) {
            if (data.get(i).getName().toString().equals(name)) {
                searchDate.add(i);
            }
        }
        return searchDate;
    }

    public Address_6_2 searchIndex(int index){
        return data.get(index);
    }
}
