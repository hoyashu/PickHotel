package com.example.board.service;

import com.example.board.model.ReportVo;

import java.util.List;

public class ReprotServiceImpl implements ReprotService {
    @Override
    public int retrieveReportListCount() {
        return 0;
    }

    @Override
    public int retrieveBlindReportListCount() {
        return 0;
    }

    @Override
    public List<ReportVo> retrieveReportList(int startRow, int postSize) {
        return null;
    }

    @Override
    public List<ReportVo> retrieveBlindReportList(List<ReportVo> reports) {
        return null;
    }

    @Override
    public void registerReport(ReportVo report) {

    }

    @Override
    public void blindReport(int no, int onOff) {

    }
}
