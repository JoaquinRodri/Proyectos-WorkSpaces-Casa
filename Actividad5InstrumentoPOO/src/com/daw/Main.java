package com.daw;

public class Main {

	public static void main(String[] args) {
		
		Piano p = new Piano();
		
		p.add(enumNotas.DO);
		p.add(enumNotas.RE);
		p.add(enumNotas.MI);
		p.add(enumNotas.LA);
		p.add(enumNotas.SI);
		p.add(enumNotas.FA);
		p.add(enumNotas.SI);
		
		
		p.interpretar();
		
		Campana c = new Campana();
		
		c.add(enumNotas.SOL);
		c.add(enumNotas.FA);
		c.add(enumNotas.MI);
		c.add(enumNotas.LA);
		c.add(enumNotas.RE);
		c.add(enumNotas.DO);
		c.add(enumNotas.SI);
		
		c.interpretar();

	}

}
