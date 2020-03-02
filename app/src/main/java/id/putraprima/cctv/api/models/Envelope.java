package id.putraprima.cctv.api.models;

import java.util.List;

public class Envelope<T> {
   Links links;
   Meta meta;
   List<T> data;

   public Envelope(Links links, Meta meta, List<T> data) {
      this.links = links;
      this.meta = meta;
      this.data = data;
   }

   public Envelope() {
   }

   public Links getLinks() {
      return links;
   }

   public void setLinks(Links links) {
      this.links = links;
   }

   public Meta getMeta() {
      return meta;
   }

   public void setMeta(Meta meta) {
      this.meta = meta;
   }

   public List<T> getData() {
      return data;
   }

   public void setData(List<T> data) {
      this.data = data;
   }
}
