package br.edu.cs.projetos3.sebrae.feedback.entidades;

import java.time.LocalDate;
import java.util.List;

public class TaxaRetornoUsuario {
	    private Long clienteId;
	    private int currentStreak;
	    private int longestStreak;
	    private LocalDate lastLoginDate;
	    private List<LocalDate> loginHistory;

	    // Construtores, Getters e Setters
	    public TaxaRetornoUsuario() {}

	    public Long getClienteId() { return clienteId; }
	    public void setClienteId(Long clienteId) { this.clienteId = clienteId; }

	    public int getCurrentStreak() { return currentStreak; }
	    public void setCurrentStreak(int currentStreak) { this.currentStreak = currentStreak; }

	    public int getLongestStreak() { return longestStreak; }
	    public void setLongestStreak(int longestStreak) { this.longestStreak = longestStreak; }

	    public LocalDate getLastLoginDate() { return lastLoginDate; }
	    public void setLastLoginDate(LocalDate lastLoginDate) { this.lastLoginDate = lastLoginDate; }

	    public List<LocalDate> getLoginHistory() { return loginHistory; }
	    public void setLoginHistory(List<LocalDate> loginHistory) { this.loginHistory = loginHistory; }
	
}
