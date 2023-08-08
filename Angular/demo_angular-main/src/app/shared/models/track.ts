export interface Track {
    id : number;
    title : string;
    duration : number;
    album? : string;
    genre : string;
    artists : string[];
}