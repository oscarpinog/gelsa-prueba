export class ClienteDTO{
    id!:string;
    sharedKey!: string;
    businessId!: string;
    email!: string;
    phone!: string;
    dataAdded!: string;
}
export interface Cliente{
    id:string;
    sharedKey: string;
    businessId: string;
    email: string;
    phone: string;
    dataAdded: string;
}