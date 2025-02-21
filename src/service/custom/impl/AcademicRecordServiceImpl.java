package service.custom.impl;

import java.util.ArrayList;

import dao.DaoFactory;
import dao.custom.AcademicRecordDao;
import dto.AcademicRecordDto;
import entity.AcademicRecordEntity;
import service.custom.AcademicRecordService;

public class AcademicRecordServiceImpl implements AcademicRecordService {

    private AcademicRecordDao academicRecordDao =   (AcademicRecordDao) DaoFactory.getInstance().getDao(DaoFactory.DaoType.ACADEMICRECORD);

    @Override
    public ArrayList<AcademicRecordDto> getAll(String StudentID) throws Exception {
        ArrayList<AcademicRecordDto> academicRecordDtos = new ArrayList<>();
        ArrayList<AcademicRecordEntity> academicRecordEntities = academicRecordDao.getAll(StudentID);
        for (AcademicRecordEntity academicRecordEntity : academicRecordEntities) {
            AcademicRecordDto dto = new AcademicRecordDto(academicRecordEntity.getCourseId(),academicRecordEntity.getSemester(),academicRecordEntity.getGrade());
            academicRecordDtos.add(dto);
    }
    return academicRecordDtos;
 }

}
