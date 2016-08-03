package com.kelvearagao.wine.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kelvearagao.wine.model.Vinho;

public interface Vinhos extends JpaRepository<Vinho, Long> {

}
