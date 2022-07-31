export class Habilidades {
    id?: number;
    nombreH: string;
    porcentajeH: string;
    imgH: string;

    constructor(nombreH: string, porcentajeH: string, imgH: string) {
        this.nombreH = nombreH;
        this.porcentajeH = porcentajeH;
        this.imgH = imgH;
    }
}
