package com.example.enicarthage.demo_proj_A.Repositories;

import com.example.enicarthage.demo_proj_A.Models.Direction;
import com.example.enicarthage.demo_proj_A.Models.SchoolClass;
import com.example.enicarthage.demo_proj_A.Models.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpecialityRepository extends JpaRepository<Speciality, Long> {

    List<Speciality> findByDirection(Direction direction);

}
