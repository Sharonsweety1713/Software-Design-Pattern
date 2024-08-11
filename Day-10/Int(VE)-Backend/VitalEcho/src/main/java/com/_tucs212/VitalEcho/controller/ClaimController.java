// package com._tucs212.VitalEcho.controller;


// import java.util.Map;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com._tucs212.VitalEcho.model.Claim;
// import com._tucs212.VitalEcho.service.ClaimService;


// @RestController
// @RequestMapping("/claims")
// public class ClaimController {
//     @Autowired
//     private ClaimService claimService;

//     @PostMapping
//     public ResponseEntity<Claim> fileClaim(@RequestBody Claim claim) {
//         Claim savedClaim = claimService.fileClaim(claim);
//         return new ResponseEntity<>(savedClaim, HttpStatus.CREATED);
//     }

//     @PutMapping("/{claimNo}/action")
//     public ResponseEntity<Claim> updateClaimAction(@PathVariable Long claimNo, @RequestBody Map<String, Boolean> action) {
//         Claim updatedClaim = claimService.updateClaimAction(claimNo, action.get("action"));
//         return ResponseEntity.ok(updatedClaim);
//     }
// }

package com._tucs212.VitalEcho.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com._tucs212.VitalEcho.model.Claim;
import com._tucs212.VitalEcho.service.ClaimService;

@RestController
@RequestMapping("/claims")
@CrossOrigin(origins = "http://localhost:5173")
public class ClaimController {
    @Autowired
    private ClaimService claimService;

    @PostMapping
    public ResponseEntity<Claim> fileClaim(@RequestBody Claim claim) {
        Claim savedClaim = claimService.fileClaim(claim);
        return new ResponseEntity<>(savedClaim, HttpStatus.CREATED);
    }

    @PutMapping("/{claimNo}/action")
    public ResponseEntity<Claim> updateClaimAction(@PathVariable Long claimNo, @RequestBody Map<String, Boolean> action) {
        Claim updatedClaim = claimService.updateClaimAction(claimNo, action.get("action"));
        return ResponseEntity.ok(updatedClaim);
    }

    @GetMapping
    public ResponseEntity<List<Claim>> getAllClaims() {
        List<Claim> claims = claimService.getAllClaims();
        return ResponseEntity.ok(claims);
    }
}
