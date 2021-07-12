package me.igormgs;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

import me.igormgs.db.MySQLManager;
import me.igormgs.timers.Stats;

public class Comandos implements CommandExecutor {
	
	public static boolean verificarNumero(String numero) {
	    try {
	      Integer.parseInt(numero);
	    } catch (NumberFormatException e) {
	    	return false;
	    }
	    return true;
	  }
	
	@Override
	public boolean onCommand(CommandSender parametroSender, Command parametroComando, String parametroLabel, String[] parametroArgumentos) {
		Player parametroJogador = (Player)parametroSender;
		if(parametroJogador instanceof Player) {
			if(parametroLabel.equalsIgnoreCase("lobby")) {
				parametroJogador.sendMessage("�a�lCONEX�O �fConectando-se ao �aLobby�f.");
				 ByteArrayDataOutput out = ByteStreams.newDataOutput();
			     out.writeUTF("Connect");
			     out.writeUTF("LOBBY");
			     parametroJogador.sendPluginMessage(Main.plugin, "BungeeCord", out.toByteArray());
				return true;
			}
			
			if(parametroLabel.equalsIgnoreCase("tempo")) {
				try {
					if(MySQLManager.getRank(parametroJogador) == 15) {
						if(parametroArgumentos.length < 1) {
							parametroJogador.playSound(parametroJogador.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
							parametroJogador.sendMessage("�a�lTEMPO �fComando incorreto, utilize: /�eTEMPO �f(�eTEMPO�f).");
						    Framework.sendTitle(parametroJogador, "�a�lTEMPO");
						    Framework.sendSubTitle(parametroJogador, "�7Comando incorreto.");
						} else if(parametroArgumentos.length > 1) {
							
						} else if(parametroArgumentos.length == 1) {
							if(verificarNumero(parametroArgumentos[0]) == true) {
								if(Main.stats == Stats.AGUARDANDO_JOGADORES) {
						            int tempo = Integer.parseInt(parametroArgumentos[0]);
						            if (tempo == 0) {
						            	Framework.iniciarPartida();
										parametroJogador.playSound(parametroJogador.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
										parametroJogador.sendMessage("�a�lTEMPO �fTempo alterado.");
									    Framework.sendTitle(parametroJogador, " ");
									    Framework.sendSubTitle(parametroJogador, "�7Tempo alterado.");
						            } else {
						              Main.TimerIniciando = tempo;
										parametroJogador.playSound(parametroJogador.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
										parametroJogador.sendMessage("�a�lTEMPO �fTempo alterado.");
									    Framework.sendTitle(parametroJogador, " ");
									    Framework.sendSubTitle(parametroJogador, "�7Tempo alterado.");
						            }
								} else 	if(Main.stats == Stats.INVENCIBILIDADE) {
						            int tempo = Integer.parseInt(parametroArgumentos[0]);
						            if (tempo == 0) {
										parametroJogador.playSound(parametroJogador.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
										parametroJogador.sendMessage("�a�lTEMPO �fInsira um valor maior que 0.");
						            } else {
						                Main.TimerInvencibilidade = tempo;
										parametroJogador.playSound(parametroJogador.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
										parametroJogador.sendMessage("�a�lTEMPO �fTempo alterado.");
									    Framework.sendTitle(parametroJogador, " ");
									    Framework.sendSubTitle(parametroJogador, "�7Tempo alterado.");
						            }
								} else 	if(Main.stats == Stats.ANDAMENTO) {
						            int tempo = Integer.parseInt(parametroArgumentos[0]);
						            if (tempo == 0) {
										parametroJogador.playSound(parametroJogador.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
										parametroJogador.sendMessage("�a�lTEMPO �fInsira um valor maior que 0.");
						            } else {
						                Main.TimerAndamento = tempo;
										parametroJogador.playSound(parametroJogador.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
										parametroJogador.sendMessage("�a�lTEMPO �fTempo alterado.");
									    Framework.sendTitle(parametroJogador, " ");
									    Framework.sendSubTitle(parametroJogador, "�7Tempo alterado.");
						            }
								}
							} else {
								parametroJogador.playSound(parametroJogador.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								parametroJogador.sendMessage("�a�lTEMPO �fComando incorreto, utilize: /�eTEMPO �f(�eTEMPO�f).");
							    Framework.sendTitle(parametroJogador, "�a�lTEMPO");
							    Framework.sendSubTitle(parametroJogador, "�7Comando incorreto.");
							}
						}
						return false;
					}else if(MySQLManager.getRank(parametroJogador) == 14) {
						if(parametroArgumentos.length < 1) {
							parametroJogador.playSound(parametroJogador.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
							parametroJogador.sendMessage("�a�lTEMPO �fComando incorreto, utilize: /�eTEMPO �f(�eTEMPO�f).");
						    Framework.sendTitle(parametroJogador, "�a�lTEMPO");
						    Framework.sendSubTitle(parametroJogador, "�7Comando incorreto.");
						} else if(parametroArgumentos.length > 1) {
							
						} else if(parametroArgumentos.length == 1) {
							if(verificarNumero(parametroArgumentos[0]) == true) {
								if(Main.stats == Stats.AGUARDANDO_JOGADORES) {
						            int tempo = Integer.parseInt(parametroArgumentos[0]);
						            if (tempo == 0) {
						            	Framework.iniciarPartida();
										parametroJogador.playSound(parametroJogador.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
										parametroJogador.sendMessage("�a�lTEMPO �fTempo alterado.");
									    Framework.sendTitle(parametroJogador, " ");
									    Framework.sendSubTitle(parametroJogador, "�7Tempo alterado.");
						            } else {
						              Main.TimerIniciando = tempo;
										parametroJogador.playSound(parametroJogador.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
										parametroJogador.sendMessage("�a�lTEMPO �fTempo alterado.");
									    Framework.sendTitle(parametroJogador, " ");
									    Framework.sendSubTitle(parametroJogador, "�7Tempo alterado.");
						            }
								} else 	if(Main.stats == Stats.INVENCIBILIDADE) {
						            int tempo = Integer.parseInt(parametroArgumentos[0]);
						            if (tempo == 0) {
										parametroJogador.playSound(parametroJogador.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
										parametroJogador.sendMessage("�a�lTEMPO �fInsira um valor maior que 0.");
						            } else {
						                Main.TimerInvencibilidade = tempo;
										parametroJogador.playSound(parametroJogador.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
										parametroJogador.sendMessage("�a�lTEMPO �fTempo alterado.");
									    Framework.sendTitle(parametroJogador, " ");
									    Framework.sendSubTitle(parametroJogador, "�7Tempo alterado.");
						            }
								} else 	if(Main.stats == Stats.ANDAMENTO) {
						            int tempo = Integer.parseInt(parametroArgumentos[0]);
						            if (tempo == 0) {
										parametroJogador.playSound(parametroJogador.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
										parametroJogador.sendMessage("�a�lTEMPO �fInsira um valor maior que 0.");
						            } else {
						                Main.TimerAndamento = tempo;
										parametroJogador.playSound(parametroJogador.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
										parametroJogador.sendMessage("�a�lTEMPO �fTempo alterado.");
									    Framework.sendTitle(parametroJogador, " ");
									    Framework.sendSubTitle(parametroJogador, "�7Tempo alterado.");
						            }
								}
							} else {
								parametroJogador.playSound(parametroJogador.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								parametroJogador.sendMessage("�a�lTEMPO �fComando incorreto, utilize: /�eTEMPO �f(�eTEMPO�f).");
							    Framework.sendTitle(parametroJogador, "�a�lTEMPO");
							    Framework.sendSubTitle(parametroJogador, "�7Comando incorreto.");
							}
						}
						return false;
					}else if(MySQLManager.getRank(parametroJogador) == 13) {
						if(parametroArgumentos.length < 1) {
							parametroJogador.playSound(parametroJogador.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
							parametroJogador.sendMessage("�a�lTEMPO �fComando incorreto, utilize: /�eTEMPO �f(�eTEMPO�f).");
						    Framework.sendTitle(parametroJogador, "�a�lTEMPO");
						    Framework.sendSubTitle(parametroJogador, "�7Comando incorreto.");
						} else if(parametroArgumentos.length > 1) {
							
						} else if(parametroArgumentos.length == 1) {
							if(verificarNumero(parametroArgumentos[0]) == true) {
								if(Main.stats == Stats.AGUARDANDO_JOGADORES) {
						            int tempo = Integer.parseInt(parametroArgumentos[0]);
						            if (tempo == 0) {
						            	Framework.iniciarPartida();
										parametroJogador.playSound(parametroJogador.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
										parametroJogador.sendMessage("�a�lTEMPO �fTempo alterado.");
									    Framework.sendTitle(parametroJogador, " ");
									    Framework.sendSubTitle(parametroJogador, "�7Tempo alterado.");
						            } else {
						              Main.TimerIniciando = tempo;
										parametroJogador.playSound(parametroJogador.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
										parametroJogador.sendMessage("�a�lTEMPO �fTempo alterado.");
									    Framework.sendTitle(parametroJogador, " ");
									    Framework.sendSubTitle(parametroJogador, "�7Tempo alterado.");
						            }
								} else 	if(Main.stats == Stats.INVENCIBILIDADE) {
						            int tempo = Integer.parseInt(parametroArgumentos[0]);
						            if (tempo == 0) {
										parametroJogador.playSound(parametroJogador.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
										parametroJogador.sendMessage("�a�lTEMPO �fInsira um valor maior que 0.");
						            } else {
						                Main.TimerInvencibilidade = tempo;
										parametroJogador.playSound(parametroJogador.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
										parametroJogador.sendMessage("�a�lTEMPO �fTempo alterado.");
									    Framework.sendTitle(parametroJogador, " ");
									    Framework.sendSubTitle(parametroJogador, "�7Tempo alterado.");
						            }
								} else 	if(Main.stats == Stats.ANDAMENTO) {
						            int tempo = Integer.parseInt(parametroArgumentos[0]);
						            if (tempo == 0) {
										parametroJogador.playSound(parametroJogador.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
										parametroJogador.sendMessage("�a�lTEMPO �fInsira um valor maior que 0.");
						            } else {
						                Main.TimerAndamento = tempo;
										parametroJogador.playSound(parametroJogador.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
										parametroJogador.sendMessage("�a�lTEMPO �fTempo alterado.");
									    Framework.sendTitle(parametroJogador, " ");
									    Framework.sendSubTitle(parametroJogador, "�7Tempo alterado.");
						            }
								}
							} else {
								parametroJogador.playSound(parametroJogador.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								parametroJogador.sendMessage("�a�lTEMPO �fComando incorreto, utilize: /�eTEMPO �f(�eTEMPO�f).");
							    Framework.sendTitle(parametroJogador, "�a�lTEMPO");
							    Framework.sendSubTitle(parametroJogador, "�7Comando incorreto.");
							}
						}
						return false;
					}else if(MySQLManager.getRank(parametroJogador) == 12) {
						if(parametroArgumentos.length < 1) {
							parametroJogador.playSound(parametroJogador.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
							parametroJogador.sendMessage("�a�lTEMPO �fComando incorreto, utilize: /�eTEMPO �f(�eTEMPO�f).");
						    Framework.sendTitle(parametroJogador, "�a�lTEMPO");
						    Framework.sendSubTitle(parametroJogador, "�7Comando incorreto.");
						} else if(parametroArgumentos.length > 1) {
							
						} else if(parametroArgumentos.length == 1) {
							if(verificarNumero(parametroArgumentos[0]) == true) {
								if(Main.stats == Stats.AGUARDANDO_JOGADORES) {
						            int tempo = Integer.parseInt(parametroArgumentos[0]);
						            if (tempo == 0) {
						            	Framework.iniciarPartida();
										parametroJogador.playSound(parametroJogador.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
										parametroJogador.sendMessage("�a�lTEMPO �fTempo alterado.");
									    Framework.sendTitle(parametroJogador, " ");
									    Framework.sendSubTitle(parametroJogador, "�7Tempo alterado.");
						            } else {
						              Main.TimerIniciando = tempo;
										parametroJogador.playSound(parametroJogador.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
										parametroJogador.sendMessage("�a�lTEMPO �fTempo alterado.");
									    Framework.sendTitle(parametroJogador, " ");
									    Framework.sendSubTitle(parametroJogador, "�7Tempo alterado.");
						            }
								} else 	if(Main.stats == Stats.INVENCIBILIDADE) {
						            int tempo = Integer.parseInt(parametroArgumentos[0]);
						            if (tempo == 0) {
										parametroJogador.playSound(parametroJogador.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
										parametroJogador.sendMessage("�a�lTEMPO �fInsira um valor maior que 0.");
						            } else {
						                Main.TimerInvencibilidade = tempo;
										parametroJogador.playSound(parametroJogador.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
										parametroJogador.sendMessage("�a�lTEMPO �fTempo alterado.");
									    Framework.sendTitle(parametroJogador, " ");
									    Framework.sendSubTitle(parametroJogador, "�7Tempo alterado.");
						            }
								} else 	if(Main.stats == Stats.ANDAMENTO) {
						            int tempo = Integer.parseInt(parametroArgumentos[0]);
						            if (tempo == 0) {
										parametroJogador.playSound(parametroJogador.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
										parametroJogador.sendMessage("�a�lTEMPO �fInsira um valor maior que 0.");
						            } else {
						                Main.TimerAndamento = tempo;
										parametroJogador.playSound(parametroJogador.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
										parametroJogador.sendMessage("�a�lTEMPO �fTempo alterado.");
									    Framework.sendTitle(parametroJogador, " ");
									    Framework.sendSubTitle(parametroJogador, "�7Tempo alterado.");
						            }
								}
							} else {
								parametroJogador.playSound(parametroJogador.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								parametroJogador.sendMessage("�a�lTEMPO �fComando incorreto, utilize: /�eTEMPO �f(�eTEMPO�f).");
							    Framework.sendTitle(parametroJogador, "�a�lTEMPO");
							    Framework.sendSubTitle(parametroJogador, "�7Comando incorreto.");
							}
						}
						return false;
					}else if(MySQLManager.getRank(parametroJogador) == 11) {
						if(parametroArgumentos.length < 1) {
							parametroJogador.playSound(parametroJogador.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
							parametroJogador.sendMessage("�a�lTEMPO �fComando incorreto, utilize: /�eTEMPO �f(�eTEMPO�f).");
						    Framework.sendTitle(parametroJogador, "�a�lTEMPO");
						    Framework.sendSubTitle(parametroJogador, "�7Comando incorreto.");
						} else if(parametroArgumentos.length > 1) {
							
						} else if(parametroArgumentos.length == 1) {
							if(verificarNumero(parametroArgumentos[0]) == true) {
								if(Main.stats == Stats.AGUARDANDO_JOGADORES) {
						            int tempo = Integer.parseInt(parametroArgumentos[0]);
						            if (tempo == 0) {
						            	Framework.iniciarPartida();
										parametroJogador.playSound(parametroJogador.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
										parametroJogador.sendMessage("�a�lTEMPO �fTempo alterado.");
									    Framework.sendTitle(parametroJogador, " ");
									    Framework.sendSubTitle(parametroJogador, "�7Tempo alterado.");
						            } else {
						              Main.TimerIniciando = tempo;
										parametroJogador.playSound(parametroJogador.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
										parametroJogador.sendMessage("�a�lTEMPO �fTempo alterado.");
									    Framework.sendTitle(parametroJogador, " ");
									    Framework.sendSubTitle(parametroJogador, "�7Tempo alterado.");
						            }
								} else 	if(Main.stats == Stats.INVENCIBILIDADE) {
						            int tempo = Integer.parseInt(parametroArgumentos[0]);
						            if (tempo == 0) {
										parametroJogador.playSound(parametroJogador.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
										parametroJogador.sendMessage("�a�lTEMPO �fInsira um valor maior que 0.");
						            } else {
						                Main.TimerInvencibilidade = tempo;
										parametroJogador.playSound(parametroJogador.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
										parametroJogador.sendMessage("�a�lTEMPO �fTempo alterado.");
									    Framework.sendTitle(parametroJogador, " ");
									    Framework.sendSubTitle(parametroJogador, "�7Tempo alterado.");
						            }
								} else 	if(Main.stats == Stats.ANDAMENTO) {
						            int tempo = Integer.parseInt(parametroArgumentos[0]);
						            if (tempo == 0) {
										parametroJogador.playSound(parametroJogador.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
										parametroJogador.sendMessage("�a�lTEMPO �fInsira um valor maior que 0.");
						            } else {
						                Main.TimerAndamento = tempo;
										parametroJogador.playSound(parametroJogador.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
										parametroJogador.sendMessage("�a�lTEMPO �fTempo alterado.");
									    Framework.sendTitle(parametroJogador, " ");
									    Framework.sendSubTitle(parametroJogador, "�7Tempo alterado.");
						            }
								}
							} else {
								parametroJogador.playSound(parametroJogador.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								parametroJogador.sendMessage("�a�lTEMPO �fComando incorreto, utilize: /�eTEMPO �f(�eTEMPO�f).");
							    Framework.sendTitle(parametroJogador, "�a�lTEMPO");
							    Framework.sendSubTitle(parametroJogador, "�7Comando incorreto.");
							}
						}
						return false;
					}else if(MySQLManager.getRank(parametroJogador) == 10) {
						parametroJogador.playSound(parametroJogador.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						parametroJogador.sendMessage("�a�lCHAT �fComando n�o encontrado.");
					    Framework.sendTitle(parametroJogador, "�4�lERRO");
					    Framework.sendSubTitle(parametroJogador, "�fComando n�o registrado.");
						return false;
					}else if(MySQLManager.getRank(parametroJogador) == 9) {
						parametroJogador.playSound(parametroJogador.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						parametroJogador.sendMessage("�a�lCHAT �fComando n�o encontrado.");
					    Framework.sendTitle(parametroJogador, "�4�lERRO");
					    Framework.sendSubTitle(parametroJogador, "�fComando n�o registrado.");
						return false;
					}else if(MySQLManager.getRank(parametroJogador) == 8) {
						parametroJogador.playSound(parametroJogador.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						parametroJogador.sendMessage("�a�lCHAT �fComando n�o encontrado.");
					    Framework.sendTitle(parametroJogador, "�4�lERRO");
					    Framework.sendSubTitle(parametroJogador, "�fComando n�o registrado.");
						return false;
					}else if(MySQLManager.getRank(parametroJogador) == 7) {
						parametroJogador.playSound(parametroJogador.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						parametroJogador.sendMessage("�a�lCHAT �fComando n�o encontrado.");
					    Framework.sendTitle(parametroJogador, "�4�lERRO");
					    Framework.sendSubTitle(parametroJogador, "�fComando n�o registrado.");
						return false;
					}else if(MySQLManager.getRank(parametroJogador) == 6) {
						parametroJogador.playSound(parametroJogador.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						parametroJogador.sendMessage("�a�lCHAT �fComando n�o encontrado.");
					    Framework.sendTitle(parametroJogador, "�4�lERRO");
					    Framework.sendSubTitle(parametroJogador, "�fComando n�o registrado.");
						return false;
					}else if(MySQLManager.getRank(parametroJogador) == 5) {
						parametroJogador.playSound(parametroJogador.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						parametroJogador.sendMessage("�a�lCHAT �fComando n�o encontrado.");
					    Framework.sendTitle(parametroJogador, "�4�lERRO");
					    Framework.sendSubTitle(parametroJogador, "�fComando n�o registrado.");
						return false;
					}else if(MySQLManager.getRank(parametroJogador) == 4) {
						parametroJogador.playSound(parametroJogador.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						parametroJogador.sendMessage("�a�lCHAT �fComando n�o encontrado.");
					    Framework.sendTitle(parametroJogador, "�4�lERRO");
					    Framework.sendSubTitle(parametroJogador, "�fComando n�o registrado.");
						return false;
					}else if(MySQLManager.getRank(parametroJogador) == 3) {
						parametroJogador.playSound(parametroJogador.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						parametroJogador.sendMessage("�a�lCHAT �fComando n�o encontrado.");
					    Framework.sendTitle(parametroJogador, "�4�lERRO");
					    Framework.sendSubTitle(parametroJogador, "�fComando n�o registrado.");
						return false;
					}else if(MySQLManager.getRank(parametroJogador) == 2) {
						parametroJogador.playSound(parametroJogador.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						parametroJogador.sendMessage("�a�lCHAT �fComando n�o encontrado.");
					    Framework.sendTitle(parametroJogador, "�4�lERRO");
					    Framework.sendSubTitle(parametroJogador, "�fComando n�o registrado.");
						return false;
					}else if(MySQLManager.getRank(parametroJogador) == 1) {
						parametroJogador.playSound(parametroJogador.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						parametroJogador.sendMessage("�a�lCHAT �fComando n�o encontrado.");
					    Framework.sendTitle(parametroJogador, "�4�lERRO");
					    Framework.sendSubTitle(parametroJogador, "�fComando n�o registrado.");
						return false;
					}else if(MySQLManager.getRank(parametroJogador) == 0) {
						parametroJogador.playSound(parametroJogador.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						parametroJogador.sendMessage("�a�lCHAT �fComando n�o encontrado.");
					    Framework.sendTitle(parametroJogador, "�4�lERRO");
					    Framework.sendSubTitle(parametroJogador, "�fComando n�o registrado.");
						return false;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} else {
			System.out.println("APENAS JOGADOREs");
			return false;
		}
		return false;
	}

}