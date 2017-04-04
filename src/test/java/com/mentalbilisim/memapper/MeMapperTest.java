package com.mentalbilisim.memapper;

import static org.junit.Assert.*;

import com.mentalbilisim.memapper.to.EnumGender;
import com.mentalbilisim.memapper.to.NameTo;
import com.mentalbilisim.memapper.to.TargetPersonNoEmptyConstructorTo;
import com.mentalbilisim.memapper.to.TargetPersonTo;
import com.mentalbilisim.memapper.to.TrainerPersonTo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Test;


/**
 * Created by erhan.karakaya on 4/3/2017.
 */
public class MeMapperTest {
  private static final Integer ID = 31648;
  private static final String TITLE = "TITLE";
  private static final String FIRST_NAME = "FIRST_NAME";
  private static final String MIDDLE_NAME = "MIDDLE_NAME";
  private static final String LAST_NAME = "LAST_NAME";
  private static final EnumGender GENDER = EnumGender.FEMALE;
  private static final List<String> LESSONS = Arrays.asList("a", "b", "c", "d", "e");
  private static final Double SALARY = 5246.67;

  @Test
  public void shouldThrowException_whenCallingConstructorPublicly() {
    try {
      MeMapper mapper = MeMapper.class.newInstance();
      fail();
    } catch (InstantiationException e) {
      return;
    } catch (IllegalAccessException e) {
      return;
    }
  }

  @Test
  public void shouldMapAllFields_whenTargetClassIsGiven() {
    TrainerPersonTo trainerPersonTo = prepareTrainer();

    Optional<TargetPersonTo> targetPersonToOptional = MeMapper.getMapperFrom(trainerPersonTo)
        .mapTo(TargetPersonTo.class);

    TargetPersonTo targetPersonTo = targetPersonToOptional.get();
    assertEquals(trainerPersonTo.getLessons(), targetPersonTo.getLessons());
    assertEquals(trainerPersonTo.getSalary(), targetPersonTo.getSalary());
    assertEquals(trainerPersonTo.getGender(), targetPersonTo.getGender());
    assertEquals(trainerPersonTo.getId(), targetPersonTo.getId());
    assertEquals(trainerPersonTo.getName(), targetPersonTo.getName());
    assertEquals(trainerPersonTo.getTitle(), targetPersonTo.getTitle());
  }

  @Test
  public void shouldReturnEmpty_whenTargetClassIsGivenAndTargetHasNotEmptyConstructor() {
    TrainerPersonTo trainerPersonTo = prepareTrainer();

    Optional<TargetPersonNoEmptyConstructorTo> optional =
        MeMapper.getMapperFrom(trainerPersonTo)
            .mapTo(TargetPersonNoEmptyConstructorTo.class);

    assertFalse(optional.isPresent());
  }


  @Test
  public void shouldMapAllItemInList_whenTargetClassIsGiven() {
    final int size = 20;
    List<TrainerPersonTo> trainerPersonTos = prepareTrainerList(size);

    Optional<List<TargetPersonTo>> optional = MeMapper.getMapperFromList(trainerPersonTos)
        .mapToList(TargetPersonTo.class);

    List<TargetPersonTo> targetPersonTos = optional.get();

    assertEquals(size, targetPersonTos.size());
  }


  private TrainerPersonTo prepareTrainer() {
    TrainerPersonTo trainer = new TrainerPersonTo();

    trainer.setId(ID);
    trainer.setTitle(TITLE);
    trainer.setName(new NameTo(FIRST_NAME, MIDDLE_NAME, LAST_NAME));
    trainer.setLessons(LESSONS);
    trainer.setSalary(SALARY);
    trainer.setGender(GENDER);

    return trainer;
  }

  private List<TrainerPersonTo> prepareTrainerList(int size) {
    List<TrainerPersonTo> trainers = new ArrayList<>();

    for (int i = 0; i < size; i++) {
      TrainerPersonTo trainer = new TrainerPersonTo();
      trainer.setId(ID + i);
      trainer.setTitle(TITLE + "_" + i);
      trainer.setName(new NameTo(FIRST_NAME + "_" + i, MIDDLE_NAME + "_" + i, LAST_NAME + "_" + i));
      trainer.setLessons(LESSONS);
      trainer.setSalary(SALARY);
      trainer.setGender(GENDER);
      trainers.add(trainer);
    }
    return trainers;
  }
}