package medical.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class MedicalService implements IMedicalService{
    @Override
    public List<Integer> age() {
        List<Integer> age= new ArrayList<>();
        age.add(1990);
        age.add(1991);
        age.add(1992);
        age.add(1993);
        age.add(1994);
        age.add(1995);
        age.add(1996);
        age.add(1997);
        return age;
    }

    @Override
    public List<Integer> day() {
        List<Integer> day= new ArrayList<>();
        day.add(1);
        day.add(2);
        day.add(3);
        day.add(4);
        day.add(5);
        day.add(6);
        day.add(7);
        day.add(8);
        day.add(9);
        day.add(10);
        day.add(11);
        day.add(12);
        day.add(13);
        day.add(14);
        day.add(15);
        day.add(16);
        day.add(17);
        day.add(18);
        day.add(19);
        day.add(20);
        day.add(21);
        day.add(22);
        day.add(23);
        day.add(24);
        day.add(25);
        day.add(26);
        day.add(27);
        day.add(28);
        day.add(29);
        day.add(30);
        return day;
    }

    @Override
    public List<Integer> month() {
        List<Integer> month= new ArrayList<>();
        month.add(1);
        month.add(2);
        month.add(3);
        month.add(4);
        month.add(5);
        month.add(6);
        month.add(7);
        month.add(8);
        month.add(9);
        month.add(10);
        month.add(11);
        month.add(12);
        return month;
    }

    @Override
    public List<Integer> year() {
        List<Integer> year= new ArrayList<>();
        year.add(2022);
        year.add(2021);
        year.add(2020);
        year.add(2019);
        year.add(2018);
        return year;
    }

    @Override
    public List<String> gender() {
        List<String> gender= new ArrayList<>();
        gender.add("Nam");
        gender.add("Nữ");
        gender.add("Khác");
        return gender;
    }

    @Override
    public List<String> nation() {
        List<String> nation= new ArrayList<>();
        nation.add("Việt Nam");
        nation.add("Trung Quốc");
        nation.add("Nhật Bản");
        nation.add("Mỹ");
        return nation;
    }
}
