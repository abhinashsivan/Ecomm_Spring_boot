package com.Ecomm.ecomm.product.services;

import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;

@Service
public class yamlFileServices {

    public String getUrl() throws FileNotFoundException {

        Yaml yaml = new Yaml();

        String path = "src/main/resources/api.yaml";

        Map<String, String> map = yaml.load(new FileInputStream(new File(path)));

        return map.get("url");
    }
}
