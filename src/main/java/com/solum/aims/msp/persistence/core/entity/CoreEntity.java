package com.solum.aims.msp.persistence.core.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.stream.Collectors;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.SequenceGenerator;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Inheritance(strategy = InheritanceType.JOINED)
@MappedSuperclass
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public abstract class CoreEntity implements Serializable {
	protected static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "ID_GENERATOR")
//	@GenericGenerator(name = "ID_GENERATOR", strategy = "enhanced-sequence", parameters = @Parameter(name = "sequence_name", value = "aims_core_entity_sequence"))
	@SequenceGenerator(allocationSize = 1, name = "aims_core_entity_sequence")
	private long id;

	@Column(unique = true)
	private String code;

	@Column(name = "group_id")
	private String groupId;

	public interface State {
		static <T extends Enum<T>> Collection<State> toStates(Collection<String> states, Class<T> enumType) {
			return states.stream().map(state -> (State) Enum.valueOf(enumType, state.toUpperCase()))
					.collect(Collectors.toList());
		}

		static <T extends Enum<T>> State toState(String state, Class<T> enumType) {
			return (State) Enum.valueOf(enumType, state.toUpperCase());
		}
	}
}