package com.hackaton.finishdown.repos;

import com.hackaton.finishdown.domain.Story;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Component;

import java.util.List;

public interface StoryRepo extends JpaRepository<Story, Long> {

    Story findById(long id);

}
