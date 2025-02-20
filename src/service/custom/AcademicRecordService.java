package service.custom;

import java.util.ArrayList;

import dto.AcademicRecordDto;
import service.SuperService;

public interface AcademicRecordService extends SuperService {
    public ArrayList<AcademicRecordDto> getAll(String StudentID) throws Exception;
}
