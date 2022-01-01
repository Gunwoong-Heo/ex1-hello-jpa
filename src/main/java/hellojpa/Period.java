package hellojpa;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Embeddable
public class Period {
    private LocalDateTime startDate;
    private LocalDateTime endDAte;

//    public boolean isWork() {
//        // 필요한 로직 추가
//    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDAte() {
        return endDAte;
    }

    public void setEndDAte(LocalDateTime endDAte) {
        this.endDAte = endDAte;
    }
}
