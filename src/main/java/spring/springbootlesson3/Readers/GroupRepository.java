package spring.springbootlesson3.Readers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import spring.springbootlesson3.Tables.Group;

import java.util.List;

public interface GroupRepository extends JpaRepository<Group, Integer> {
    List<Group> findAllByFaculty_University_Id(Integer faculty_university_id);

    //    List<Group> getGroupByFaculty_IdOrderByNameAsc();
    @Query("select gr from groups gr where gr.faculty.university.id=:universityId")
    List<Group> getGroupByUniversityId(Integer universityId);

    @Query(value = "select * from groups join faculty on faculty.id = groups.faculty_id  join  university  on university.id=faculty.university_id", nativeQuery = true)
    List<Group> getGroupsByUniversityIdNative();
}
