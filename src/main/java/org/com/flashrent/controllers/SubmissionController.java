package org.com.flashrent.controllers;

import org.com.flashrent.entities.Submission;
import org.com.flashrent.services.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/submissions")
public class SubmissionController {
    @Autowired
    private SubmissionService submissionService;

    @GetMapping
    public ResponseEntity<List<Submission>> getAllSubmissions() {
        List<Submission> submissions = submissionService.getAllSubmissions();
        return new ResponseEntity<>(submissions, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Submission> getSubmissionById(@PathVariable("id") Long id) {
        return submissionService.getSubmissionById(id)
                .map(submission -> new ResponseEntity<>(submission, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Submission> createSubmission(@RequestBody Submission submission) {
        Submission savedSubmission = submissionService.saveSubmission(submission);
        return new ResponseEntity<>(savedSubmission, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubmission(@PathVariable("id") Long id) {
        submissionService.deleteSubmissionById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
