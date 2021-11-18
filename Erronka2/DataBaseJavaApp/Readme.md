# Datu Atzipena
Spring erabilita eta hibernate orm a ren laguntzarekin postgres datu basetik interesatzen zaizkigun entitateak mapeatu ditugu eta sql express zerbitzari batean entitate berriak sortu ditugu interesatzen zitzaizkigun datuekin

![Alt text](https://cdn.discordapp.com/attachments/805837040566534207/910799473628811264/unknown.png "Proiektu Egitura")

Aplikazio honetan klase guztiak paketeetan antolatu ditugu, model.postgres-en PostgreSql datu basetik hartuko ditugun taulak mapeatu ditugu, aldiz model.sqlserver-en aurreko entitateetatik datuak hartzen ditugu eta sortutako entitate berrietan txertatuko ditugu sqlServer-en gordetzeko.

Datu basean egiten diren aldaketak PostgresDao eta SqlServerDao-en daude eta repo paketeetan antolatu ditugu.

Objetuekin operazioak egiteko bi kontroller sortu ditugu,ControllerPostgres-en datuak hartu eta listetan txertatzen ditugu eta ControllerSql-en listeetan zehar objetu berriak sortzen joaten gara.

Kasu honetan objetuak datu base batetik bestera eramateko bi datu basearen konfigurazio behar izango ditugu, horretarako application.properties-en definitzen ditugu.
Horretaz gain aplikazioak exportazio bat egiten duen bakoitzean log batean erregistratuko da, horretarako DomApi libreria erabili dugu eta xml batean gordeko da informazioa.

*Xml-Aren egitura:*

```
<?xml version="1.0" encoding="UTF-8" standalone="no"?><?xml-stylesheet type="text/xsl" href="options.xslt"?>
<document>
	<options>
		<ProduktuKopurua>5</ProduktuKopurua>
	</options>
	<log>
		<acceso Date="11-11-2021 12:13:02">Fitxategia Sortu</acceso>
		<acceso Date="11-11-2021 12:13:02">Datu base osoa esportatu da</acceso>
		<acceso Date="11-11-2021 12:28:44">Datu base osoa esportatu da</acceso>
		<acceso Date="11-11-2021 12:29:01">Datu base osoa esportatu da</acceso>
		<acceso Date="18-11-2021 10:36:30">Aurretik dagoen konfigurazioa esportatu da, 0 produktu baino gutxiago dituzten erosketak esportatu dira</acceso>
		<acceso Date="18-11-2021 10:36:40">5 produktu baino gutxiago dituzten erosketak esportatu dira</acceso>
		<acceso Date="18-11-2021 10:36:47">Aurretik dagoen konfigurazioa esportatu da, 5 produktu baino gutxiago dituzten erosketak esportatu dira</acceso>
	</log>
</document>
```

### Klase Diagrama:

![Alt text](https://cdn.discordapp.com/attachments/805837040566534207/910830806308646922/Diagrama.png "Klase Diagrama")

Aplikazioa exekutatzean hurrengo menua ikusiko dugu:

![Alt text](https://cdn.discordapp.com/attachments/805837040566534207/910798345486860288/unknown.png "Proiektu Egitura")
