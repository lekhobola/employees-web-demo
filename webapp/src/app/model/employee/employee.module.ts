import { Company } from '../company/company.module';
import { Person } from '../person/person.module';

export class Employee extends Person{
    employeeNumber: string;
    company: Company;
}
