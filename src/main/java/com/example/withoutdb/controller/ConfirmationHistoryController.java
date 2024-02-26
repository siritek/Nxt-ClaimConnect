package com.example.withoutdb.controller;

import com.example.withoutdb.model.ConfirmationHistory;
import com.example.withoutdb.model.GWCCResponse;
import com.example.withoutdb.service.DBConn;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/confirmationHistory")
public class ConfirmationHistoryController {

    @GetMapping("/getAll")
        public List<ConfirmationHistory> ConfirmationHistory() {
            List<ConfirmationHistory> allresponses = new ArrayList<ConfirmationHistory>();
            try {
                Connection con = DBConn.getMyConnection();
                PreparedStatement ps = con.prepareStatement("select * from gwccresponsetable");
                ResultSet rs = ps.executeQuery();
                ConfirmationHistory x = null;
                while(rs.next())
                {
                    x = new ConfirmationHistory();
                    x.setGwClaimnumber(rs.getString(1));
                    x.setBaseClaimNumber(rs.getString(2));
                    x.setBasePolicyNumber(rs.getString(3));
                    x.setResponse(rs.getString(4));
                    x.setCreatedDate(rs.getString(5));
                    x.setOther(rs.getString(6));
                    allresponses.add(x);
                }
                con.close();
            }
            catch(SQLException e) {
                System.out.println("Exception in get ConfirmationHistory  method "+ e);
            }
            return allresponses;
        }
    }


