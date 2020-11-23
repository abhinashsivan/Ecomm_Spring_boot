package com.Ecomm.Ecomm.services;

import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;

@Service
public class yamlFileServices {

    public String yamlFileToMap() throws FileNotFoundException{

        Yaml yaml = new Yaml();

        String path = "http://localhost:8080/customer/search";

        Map<String, String> map = yaml.load(new FileInputStream(new File(path)));

        return map.get("url");
    }
}
