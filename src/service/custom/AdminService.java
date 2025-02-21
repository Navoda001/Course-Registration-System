package service.custom;

import dto.AdminDto;
import service.SuperService;

public interface AdminService extends SuperService {
 public AdminDto search(String userName)throws Exception;
}
