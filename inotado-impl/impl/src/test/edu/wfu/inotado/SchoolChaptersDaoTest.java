/*Licensed to The Apereo Foundation under one or more contributor license
agreements. See the NOTICE file distributed with this work for
additional information regarding copyright ownership.

The Apereo Foundation licenses this file to you under the Apache License,
Version 2.0 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at:

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.

See the License for the specific language governing permissions and
limitations under the License.*/

package edu.wfu.inotado;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.wfu.inotado.model.ScGradeDTO;
import edu.wfu.inotado.model.ScGradeScaleDTO;
import edu.wfu.inotado.model.ScRubricCriterionDTO;
import edu.wfu.inotado.model.ScRubricDTO;

public class SchoolChaptersDaoTest extends InotadoTestBase {
	private final Log log = LogFactory.getLog(this.getClass());

	public void testSaveScGrade() {
		ScGradeDTO scGrade = new ScGradeDTO();
		scGrade.setId(20);
		scGrade.setGradeId(30);
		scGrade.setCreatedAt(new Date());
		scGrade.setUpdatedAt(new Date());
		super.schoolChaptersDao.save(scGrade);
		ScGradeDTO result = super.schoolChaptersDao.findById(ScGradeDTO.class,
				20);
		assertNotNull(result);
		assertEquals(30, result.getGradeId());
	}

	public void testSaveSCGradeScale() {
		ScGradeScaleDTO scale = new ScGradeScaleDTO();
		scale.setId(12);
		scale.setName("Scale Name");
		scale.setRubricCriterionId(20);
		scale.setScore(20.9);
		scale.setCreatedAt(new Date());
		scale.setUpdatedAt(new Date());
		super.schoolChaptersDao.save(scale);
		ScGradeScaleDTO result = super.schoolChaptersDao.findById(
				ScGradeScaleDTO.class, 12);
		assertNotNull(result);
		assertEquals(20.9, result.getScore());
	}

	public void testSaveSCRubric() {
		ScRubricDTO rubric = new ScRubricDTO();
		rubric.setId(33);
		rubric.setId(1);
		rubric.setAnnotation("Annotation");
		rubric.setBaseScore(20.9);
		rubric.setCreatedAt(new Date());
		rubric.setUpdatedAt(new Date());
		rubric.setName("Name");
		rubric.setPrefectScore(100.0);
		super.schoolChaptersDao.save(rubric);
		ScRubricDTO result = super.schoolChaptersDao.findById(
				ScRubricDTO.class, 1);
		assertNotNull(result);
		assertEquals(100.0, result.getPrefectScore());

		log.info("update the same date and save it");
		rubric.setName("Updated Name");
		super.schoolChaptersDao.save(
				rubric,
				super.schoolChaptersDao.findById(ScRubricDTO.class,
						rubric.getId()));
		result = super.schoolChaptersDao.findById(
				ScRubricDTO.class, 1);
		assertEquals("Updated Name", result.getName());

	}

	public void testSaveSCRubricCriterion() {
		ScRubricCriterionDTO rubricCriterion = new ScRubricCriterionDTO();
		rubricCriterion.setId(2);
		rubricCriterion.setGradable(true);
		rubricCriterion.setCreatedAt(new Date());
		rubricCriterion.setUpdatedAt(new Date());
		rubricCriterion.setMaxScore(300.0);
		rubricCriterion.setMinScore(20.5);
		rubricCriterion.setName("Name");
		rubricCriterion.setRubricId(30);
		super.schoolChaptersDao.save(rubricCriterion);
		ScRubricCriterionDTO result = super.schoolChaptersDao.findById(
				ScRubricCriterionDTO.class, 2);
		assertNotNull(result);
		assertEquals(20.5, result.getMinScore());
	}

}
