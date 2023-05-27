package com.neu.edu.android_backend.controller;

import com.neu.edu.android_backend.mapper.SelectionMapper;
import com.neu.edu.android_backend.po.Selection;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Log4j2
@RestController
public class SelectionController {
    @Resource
    SelectionMapper selectionMapper;

    @PostMapping("/selections")
    public ResponseEntity<String> addSelection(@RequestBody Selection selection) {
        try {
            selectionMapper.addSelection(selection);
            return ResponseEntity.status(HttpStatus.CREATED).body("Selection added successfully");
        } catch (Exception e) {
            log.error("Failed to add selection", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add selection");
        }
    }

    @DeleteMapping("/selections/{id}")
    public ResponseEntity<String> deleteSelection(@PathVariable String id) {
        try {
            selectionMapper.deleteSelection(id);
            return ResponseEntity.status(HttpStatus.OK).body("Selection deleted successfully");
        } catch (Exception e) {
            log.error("Failed to delete selection", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete selection");
        }
    }

    @PutMapping("/selections")
    public ResponseEntity<String> updateSelection(@RequestBody Selection selection) {
        try {
            selectionMapper.updateSelection(selection);
            return ResponseEntity.status(HttpStatus.OK).body("Selection updated successfully");
        } catch (Exception e) {
            log.error("Failed to update selection", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update selection");
        }
    }

    @GetMapping("/selections/{id}")
    public ResponseEntity<Selection> getSelectionById(@PathVariable String id) {
        try {
            Selection selection = selectionMapper.getSelectionById(id);
            if (selection != null) {
                return ResponseEntity.status(HttpStatus.OK).body(selection);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            log.error("Failed to get selection by id", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/selections")
    public ResponseEntity<List<Selection>> getAllSelections() {
        try {
            List<Selection> selections = selectionMapper.getAllSelections();
            return ResponseEntity.status(HttpStatus.OK).body(selections);
        } catch (Exception e) {
            log.error("Failed to get all selections", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // 可以根据需要添加其他查询方法
}
