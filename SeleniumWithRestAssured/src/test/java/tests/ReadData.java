package tests;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;

import java.util.List;
import java.util.Map;

public class ReadData {


    @Given("data as maps")
    public void data_as_maps_input(DataTable dataTable){
        List<Map<String,String>> maps = dataTable.asMaps();
        maps.forEach(map->{
            System.out.println(map.get("name")+ " : "+ map.get("pass"));
        });
    }

    @Given("data as map")
    public void data_as_map_input(DataTable dataTable){
        System.out.println(" in data as map");
        Map<String, String> map = dataTable.asMap();
        map.forEach((key,value)->{
            System.out.println(key + " : "+value);
        });
    }

    @Given("data as list")
    public void data_as_list_input(DataTable dataTable){
        dataTable.asList().forEach(System.out::println);
    }
}
