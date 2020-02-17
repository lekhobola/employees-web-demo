import { Employee } from './employee.module';

describe('Employee', () => {
  it('should create an instance', () => {
    expect(new Employee()).toBeTruthy();
  });
});
