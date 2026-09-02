package example.day02.day02실습.controller실습;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import example.day02.day02실습.model실습.dao실습.WaitingDao;
import example.day02.day02실습.model실습.dto실습.WaitingDto;


@RestController
public class WaitingController {
private WaitingDao wd = WaitingDao.getInstance();


// [1] 대기 등록
    @PostMapping("/waiting/save")
    public boolean save(WaitingDto waitingDto) {
    return wd.save(waitingDto);
    }


    // [2] 대기 전체조회
    @GetMapping("/waiting/findall")
    public ArrayList<WaitingDto> findAll() {
        return wd.findAll();
    }


    // [3] 대기 인원수 수정
    @PutMapping("/waiting/update")
    public boolean update(WaitingDto waitingDto) {
        return wd.update(waitingDto);
    }


    // [4] 대기 삭제
    @DeleteMapping("/waiting/delete")
    public boolean delete(@RequestParam String phone) {
        return wd.delete(phone);
    }

}

