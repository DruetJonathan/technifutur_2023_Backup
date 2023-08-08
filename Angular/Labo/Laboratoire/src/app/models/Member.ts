export interface Member{
  id:number,
  username?: string,
  email?: string,
  birthDate: Date,
  elo: number,
  gender: UserGender,
  role:UserRole
}
export interface MemberFull{
  token:string,
  user:Member
}

export enum UserGender {
  Female = "Female",
  Male = "Male",
  Other = "Other"
}
export enum UserRole {
  Admin="Admin",
  Player="Player"
}
export interface MemberForm {
  username:string,
  email:string,
  birthdate:Date,
  elo?:number,
  gender:UserGender
}
export interface Login {
  username:string,
  password:string
}
export interface ChangePassword {
  oldPassword?:string,
  password?:string
}
