package roomescape.repository.jpa;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import roomescape.domain.Reservation;
import roomescape.domain.ReservationTime;
import roomescape.domain.Theme;

public interface JpaReservationDao extends JpaRepository<Reservation, Long> {
    List<Reservation> findByReservationMember_IdAndTheme_IdAndDateBetween(long memberId, long themeId, LocalDate start,
                                                                          LocalDate end);

    List<Reservation> findAllByReservationMember_Id(long memberId);

    List<Reservation> findAllByDateAndTheme_Id(LocalDate date, long themeId);

    boolean existsByThemeAndDateAndTime(Theme theme, LocalDate date, ReservationTime reservationTime);

    Optional<Reservation> findByThemeAndDateAndTime(Theme theme, LocalDate date, ReservationTime reservationTime);

    boolean existsByTime(ReservationTime reservationTime);

    boolean existsByTheme(Theme theme);
}
