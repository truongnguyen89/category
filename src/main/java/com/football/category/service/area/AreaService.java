package com.football.category.service.area;

import org.springframework.stereotype.Service;

import java.io.File;

/**
 * Created by IntelliJ IDEA.
 * User: Truong Nguyen
 * Date: 17-May-18
 * Time: 12:05 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
public interface AreaService {
    boolean importFromExcelFile();

    boolean importFromExcelFile(File file);
}
