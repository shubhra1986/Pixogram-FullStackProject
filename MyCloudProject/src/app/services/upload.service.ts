import { Injectable } from '@angular/core';
import { uploadMediaModel } from '../models/uploadMedia.model';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UploadService {

  private baseUrl = 'http://localhost:8762/media/media';

  constructor(private http: HttpClient) { }

   storeMedia(mediafile: uploadMediaModel, id: number, username: string): Observable<Object> {
    return this.http.post(this.baseUrl + '/create/' + id +'/' + username, mediafile);
   }
  
   getUserMedia(id: number): Observable<any> {
     return  this.http.get(this.baseUrl + '/uid/' + id);
   } 

   getOneUserMedia(id: number): Observable<any> {
    return  this.http.get(this.baseUrl + '/id/' + id);
  } 

   getAllMedia():Observable<any>{
     return this.http.get(this.baseUrl+'/allmedia');
   }
   
   updateLike(id: number, flag:number):Observable<any>{
     return this.http.put(this.baseUrl+'/like/'+`${id}`+'/'+`${flag}`,{});
   }
 
}