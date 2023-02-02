package com.certant.Consultorio.models.requests;

public enum TipoDeFechaEnum {
	UNICA("UNICA"), MULTIPLE("MULTIPLE");

	private String value;

	private TipoDeFechaEnum(String value) {
		this.value = value;
	}

	public String getTipoDeFecha() {
		return value;
	}

}