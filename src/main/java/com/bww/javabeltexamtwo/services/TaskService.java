package com.bww.javabeltexamtwo.services;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

//import com.bww.javabeltexamtwo.models.Review;
import com.bww.javabeltexamtwo.models.Task;
//import com.bww.javabeltexamtwo.repositories.Repository;
import com.bww.javabeltexamtwo.repositories.TaskRepository;

@Service
public class TaskService {

	private static TaskRepository taskRepo;
//	private static ReviewRepository revRepo;

	public TaskService(TaskRepository taskRepo) {
		this.taskRepo = taskRepo;
//		this.revRepo = revRepo;
	}

	public Task create(Task newTask) {
		return taskRepo.save(newTask);
	}

//	public Review create(Review newReview) {
//		List<Review> matchingReviews = revRepo.matchingReviews(newReview.getUser().getId(),
//				newReview.getTvShow().getId());
//		if (matchingReviews.size() > 0) {
//			return null;
//		}
//		newReview.setId(null);
//		return revRepo.save(newReview);
//	}

	public List<Task> getTask() {
		return (List<Task>) taskRepo.findAll();
	}

	public Task getTask(Long id) {
		Optional<Task> show = taskRepo.findById(id);
		return show.isPresent() ? show.get() : null;
	}

	public Task saveTask(Task task) {
		return taskRepo.save(task);
	}

	public Task update(Task toUpdate, Long id) {
		return taskRepo.save(toUpdate);
	}

	public void destory(Long id) {
		taskRepo.deleteById(id);
	}

	

}
