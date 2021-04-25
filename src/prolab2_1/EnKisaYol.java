package prolab2_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class EnKisaYol {
	public static List<Kutu> yol;
	
    public void dijkstra(Kutu baslangic){
        baslangic.setUzaklik(0);
        PriorityQueue<Kutu> kutuKuyruk = new PriorityQueue<>();
        kutuKuyruk.add(baslangic);
        baslangic.setKullanildiMi(true);

        while( !kutuKuyruk.isEmpty() ){
            Kutu kutu = kutuKuyruk.poll();
            for(Graf graf : kutu.getGrafYapisi()){
                Kutu k = graf.getBitisNoktasi();
                
                if(!k.isKullanildiMi())
                {		
                    double yeniUzaklik = kutu.getUzaklik() + graf.getMaliyet();
                    if( yeniUzaklik < k.getUzaklik() ){
                        kutuKuyruk.remove(k);
                        k.setUzaklik(yeniUzaklik);
                        k.setOncekiKutu(kutu);
                        kutuKuyruk.add(k);
                    }
                }
            }
            kutu.setKullanildiMi(true);
        }
    }

    public void enKisaYol(Kutu oyuncuKonum){
        yol = new ArrayList<>();
        for(Kutu kutu=oyuncuKonum; kutu!=null; kutu=kutu.getOncekiKutu()){
            yol.add(kutu);
        }
        Collections.reverse(yol);
    }

}