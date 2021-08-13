import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { UploadService } from 'src/app/services/upload.service';
import { Router } from '@angular/router';
import { FollowModel } from 'src/app/models/follow.model';

@Component({
  selector: 'app-follower',
  templateUrl: './follower.component.html',
  styleUrls: ['./follower.component.css']
})
export class FollowerComponent implements OnInit {
  fllwmodel:FollowModel[];
  media: any = [];
  arrofmedia:any = [];

  constructor(private userService: UserService, private uploadService:UploadService,private router: Router) { }

  ngOnInit(): void {
    //authentication
    let authval = sessionStorage.getItem("auth");
    if (authval == null) {
      this.router.navigate(["/login"]);
    }

  let myid = sessionStorage.getItem("userid"); 
  console.log(myid) 
  this.userService.getFollower(Number(myid)).subscribe(following =>{
    console.log(following+"xyz")
    this.fllwmodel=JSON.parse(JSON.stringify(following))

    for(let i=0;this.fllwmodel.length;i++){
      console.log(this.fllwmodel[i].userid)
      //passing my id to get follower
      this.uploadService.getUserMedia(Number(this.fllwmodel[i].myid)).subscribe(
        src => {
          console.log(src);
          this.media = src;
          this.arrofmedia = this.arrofmedia.concat(this.media);
          console.log(i + this.arrofmedia)
          /* this.myMedia=JSON.stringify(src);
      console.log(this.myMedia) */
        },
        error => console.log(error),
        () => {
          console.log("completed");
        }
      );
      }
   

  }
   
  
)
    
  
console.log(this.arrofmedia+"jkjdsah");    
    
    

  }


  getId(data){
    console.log(data)
    sessionStorage.setItem("intentid",data)
    
  }
  
updateLikes(data)
{
  console.log("click recorded"+data);
  this.uploadService.updateLike(data,1).subscribe();
}


decreaseLikes(data)
{
 this.uploadService.updateLike(data,0).subscribe();
} 


}
