package main.java.com.example.test.mainHandler.reportHandler;
import main.java.com.example.test.record.ReportRecord;
import main.java.com.example.test.record.PetRecord;
import main.java.com.example.test.util.ParserToBot;
import main.java.com.example.test.service.ReportService;

import static main.java.com.example.test.util.StateReport.WAIT_ID_PET_REPORT;

public class FillingReportRecord {

  /**
   * Метод создает отчет и меняет  StateReport на WAIT_ID_PET_REPORT
   * @return новый ReportRecord
   */
  public ReportRecord newReport(){

    ReportRecord reportRecord = new ReportRecord();
    reportRecord.setStateReport(WAIT_ID_PET_REPORT);
    return reportRecord;

  }

  public PetRecord checkCorrectPetId(String textMessage, ReportService reportService){

    ParserToBot parserToBot = new ParserToBot();
    Long petId = parserToBot.parserStringPetId(textMessage);

    PetRecord petRecord = petId != null ? reportService.getPetById(petId) : null;
   return petRecord;

  }



//  public ReportRecord saveReportInDb(Message message, ReportRecord reportRecord) {
//
//    long chatId = message.getChatId();
//    reportService.addReport();
//
//
//
//  }



}
