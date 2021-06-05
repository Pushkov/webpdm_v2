package nicomed.backend;

import nicomed.backend.enums.Position;
import nicomed.backend.enums.Status;
import nicomed.backend.model.Buro;
import nicomed.backend.model.PlanPoint;
import nicomed.backend.model.User;
import nicomed.backend.model.Workshop;
import nicomed.backend.repository.BuroRepository;
import nicomed.backend.repository.PlanPointRepository;
import nicomed.backend.repository.UserRepository;
import nicomed.backend.repository.WorkshopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

@Component
public class InitComponent {


    final private
    UserRepository userRepository;

    final private
    BuroRepository buroRepository;

    final private
    WorkshopRepository workshopRepository;

    final private
    PlanPointRepository planPointRepository;

    @Autowired
    public InitComponent(
            UserRepository userRepository, BuroRepository buroRepository, WorkshopRepository workshopRepository, PlanPointRepository planPointRepository) {
        this.userRepository = userRepository;
        this.buroRepository = buroRepository;
        this.workshopRepository = workshopRepository;
        this.planPointRepository = planPointRepository;
    }


    public void initTestDataBase(){

        Buro buro1 = new Buro();
        buro1.setName("БМП");
        buro1.setFullName("Бюро метизного производства");
//        buro1.setUsers(new ArrayList<>());
        buroRepository.save(buro1);

        Buro buro2 = new Buro();
        buro2.setName("АСБ");
        buro2.setFullName("Архитектурно-строительное бюро");
        buroRepository.save(buro2);

        User user1 = new User();
        user1.setLogin("11");
        user1.setPassword("$2y$12$Kxc7bYYvWcX4Q8t9on0HdelI1EYyorpiTp2c/xbjbJxeJvsKhE3VC");
        user1.setPosition(Position.ADMIN);
        user1.setFirstName("Adminchik");
        user1.setStatus(Status.ACTIVE);
        user1.setBirthday(new GregorianCalendar(1978, Calendar.JANUARY,11));
        user1.setPhone(5819L);
        user1.setCabinet(637);
        user1.setBuro(buro1);
        userRepository.save(user1);

        User user2 = new User();
        user2.setLogin("12");
        user2.setPassword("$2y$12$Kxc7bYYvWcX4Q8t9on0HdelI1EYyorpiTp2c/xbjbJxeJvsKhE3VC");
        user2.setPosition(Position.ENG);
        user2.setFirstName("Userchik");
        user2.setStatus(Status.ACTIVE);
        user2.setBirthday(new GregorianCalendar(1985,11,20));
        user2.setPhone(4140L);
        user2.setCabinet(635);
        user2.setBuro(buro2);
        userRepository.save(user2);

        System.out.println("******************************** TEST USERS ********************************  ");
        for (User u : userRepository.findAll()) {
            System.out.println(u );
        }
        System.out.println("****************************************************************************  ");

        Workshop w_enc = new Workshop();
        w_enc.setCode(10);
        w_enc.setName("ЭнЦ");
        w_enc.setFullName("Энергетический цех");
        workshopRepository.save(w_enc);
        Workshop w_stpc1 = new Workshop();
        w_stpc1.setCode(13);
        w_stpc1.setName("СтПЦ-1");
        w_stpc1.setFullName("Сталепроволочный цех №1");
        workshopRepository.save(w_stpc1);
        Workshop w_stpc2 = new Workshop();
        w_stpc2.setCode(14);
        w_stpc2.setName("СтПЦ-2");
        w_stpc2.setFullName("Сталепроволочный цех №2");
        workshopRepository.save(w_stpc2);
        Workshop w_sptc3 = new Workshop();
        w_sptc3.setCode(15);
        w_sptc3.setName("СтПЦ-3");
        w_sptc3.setFullName("Сталепроволочный цех №3");
        workshopRepository.save(w_sptc3);


        PlanPoint pp1 = PlanPoint.builder()
                .planDate(new GregorianCalendar(2020,11,15))
                .startDate(new GregorianCalendar(2020,11,5))
                .orderInPlan(1)
                .readiness(60)
                .buro(buro1)
                .endDate(new GregorianCalendar())
                .build();
        planPointRepository.save(pp1);
        PlanPoint pp2 = PlanPoint.builder()
                .planDate(new GregorianCalendar(2019,10,15))
                .startDate(new GregorianCalendar(2019,10,15))
                .orderInPlan(3)
                .readiness(100)
                .buro(buro1)
                .endDate(new GregorianCalendar())
                .build();
        planPointRepository.save(pp2);
        PlanPoint pp3 = PlanPoint.builder()
                .planDate(new GregorianCalendar(2019,9,15))
                .startDate(new GregorianCalendar(2019,9,15))
                .orderInPlan(3)
                .readiness(90)
                .buro(buro2)
                .endDate(new GregorianCalendar())
                .build();
        planPointRepository.save(pp3);
        PlanPoint pp4 = PlanPoint.builder()
                .planDate(new GregorianCalendar(2021,3,15))
                .startDate(new GregorianCalendar(2021,3,1))
                .orderInPlan(1)
                .readiness(90)
                .buro(buro1)
                .endDate(new GregorianCalendar())
                .build();
        planPointRepository.save(pp4);
    }
}
