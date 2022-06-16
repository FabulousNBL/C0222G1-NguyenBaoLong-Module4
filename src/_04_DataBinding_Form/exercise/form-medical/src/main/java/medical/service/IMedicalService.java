package medical.service;

import java.util.List;

public interface IMedicalService {
    List<Integer> age();
    List<Integer> day();
    List<Integer> month();
    List<Integer> year();
    List<String> gender();
    List<String> nation();

}
