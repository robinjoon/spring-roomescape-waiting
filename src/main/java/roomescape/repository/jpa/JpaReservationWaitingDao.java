package roomescape.repository.jpa;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import roomescape.domain.Member;
import roomescape.domain.Reservation;
import roomescape.domain.ReservationWaiting;

public interface JpaReservationWaitingDao extends JpaRepository<ReservationWaiting, Long> {
    List<ReservationWaiting> findAllByWaitingMember_Id(long waitingMemberId);

    List<ReservationWaiting> findAllByReservation(Reservation reservation);

    boolean existsByReservationAndWaitingMember(Reservation reservation, Member waitingMember);
}
