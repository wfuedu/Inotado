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

package edu.wfu.inotado.model;

public class ScRubricCriterionDTO extends ScBaseDTO {
	private int rubricId;
	private String name;
	private double maxScore;
	private double minScore;
	private boolean gradable;

	public int getRubricId() {
		return rubricId;
	}

	public void setRubricId(int rubricId) {
		this.rubricId = rubricId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMaxScore() {
		return maxScore;
	}

	public void setMaxScore(double maxScore) {
		this.maxScore = maxScore;
	}

	public double getMinScore() {
		return minScore;
	}

	public void setMinScore(double minScore) {
		this.minScore = minScore;
	}

	public boolean isGradable() {
		return gradable;
	}

	public void setGradable(boolean gradable) {
		this.gradable = gradable;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (gradable ? 1231 : 1237);
		long temp;
		temp = Double.doubleToLongBits(maxScore);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(minScore);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + rubricId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ScRubricCriterionDTO other = (ScRubricCriterionDTO) obj;
		if (gradable != other.gradable)
			return false;
		if (Double.doubleToLongBits(maxScore) != Double
				.doubleToLongBits(other.maxScore))
			return false;
		if (Double.doubleToLongBits(minScore) != Double
				.doubleToLongBits(other.minScore))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (rubricId != other.rubricId)
			return false;
		return true;
	}

}
