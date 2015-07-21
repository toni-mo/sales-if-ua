angular.module('adminApp', [ ])
    .controller( 'UsersCtrl', [function ( ) {
       this.users = [
         {
            name: "Danuliyk Taras",
            sex: "male",
            age: 21,
            email: "Danuliyk_Taras@mail.ru",
            status: "active"
         },
       {
          name: "Shevchuk Anton",
          sex: "male",
          age: 20,
          email: "ShevchukAnton@gmail.com",
          status: "active"
       } ,
       {
            name: "Ersteniyk Oksana",
            sex: "female",
            age: 20,
            email: "ErsteniykOksana@mail.ru",
            status: "active"
         },
         {
            name: "Holovcak Igor",
            sex: "male",
            age: 18,
            email: "Holovcak Igor@gmail.com",
            status: "active"
         },
         {
            name: "Danuliyk Ivan",
            sex: "male",
            age: 42,
            email: "DanuliykIvan@mail.ru",
            status: "blocked"
         },
   ];
            this.changeStatusBlocked = function(index){
            this.users[index].status = "blocked";
            };
            this.changeStatusActive = function(index){
            this.users[index].status = "active";
            };
            this.deleteUser = function(index){
            this.users.splice(index,1);
            }
            this.btnBlockName= "block";

            this.showMessage = function(status){
              if(status=="active")
                return "block"
              else
                return "unblock";
            }

            this.changeButtonName=function(index){
            if(this.users[index].status=='blocked'){
            this.btnBlockName = 'unblock';
            this.users[index].status = "active";
          }
            else {
            this.btnBlockName = 'block';
            this.users[index].status = "blocked";
          }
            }
            this.getClass = function(status){

            if(status=="blocked") 
            return{
                 
                  'fa-unlock': true
                }
                else 
                  return{
                    'fa-lock': true
                  
                  };

            }

            this.getRowStatus = function(status){
            if(status=="blocked") 
            return{
                  'PR1': true
                      }
             else 
             return{
                    'PR1': false

                       };
                     }




      } ] )


        .controller('ShopCtrl', [function ( ) {
          this.shops= [
              {
                name: "Rozetka",
                productType:"All",
                location: "Lviv, Ivano-Frankivsk",
                email:"rozetka@gmail.com",
                status:"active"
              },
              {
                name: "Electron",
                productType:"Electronic",
                location: "Kyiv",
                email:"electronKyiv@gmail.com",
                status:"active"
              },
              {
                name: "Casual",
                productType:"Clothes",
                location: "Lviv",
                email:"clothesCasualLV@ukr.net",
                status:"blocked"
              },
              {
                name: "Audi UA",
                productType:"Cars",
                location: "Kyiv, Donetsk",
                email:"audi.ua@mail.ru",
                status:"active"
              }
          ];
          this.changeStatusBlocked = function(index){
            this.shops[index].status = "blocked";
            };
            this.changeStatusActive = function(index){
            this.shops[index].status = "active";
            };
            this.deleteShop = function(index){
            this.shops.splice(index,1);
            }
            this.btnBlockName= "block";

            this.showMessage = function(status){
              if(status=="active")
                return "block"
              else
                return "unblock";
            }

            this.changeButtonName=function(index){
            if(this.shops[index].status=='blocked'){
            this.btnBlockName = 'unblock';
            this.shops[index].status = "active";
          }
            else {
            this.btnBlockName = 'block';
            this.shops[index].status = "blocked";
          }
            }
            this.getClass = function(status){

            if(status=="blocked") 
            return{
                 
                  'fa-unlock': true
                }
                else 
                  return{
                    'fa-lock': true
                  
                  };

            }

                  this.getRowStatus = function(status){

            if(status=="blocked") 
            return{
                  'PR1': true
                }
                else 
                  return{
                    'PR1': false
                  
                  };}
      } ] )