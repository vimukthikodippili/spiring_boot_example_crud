package com.example.demo.dto.paginated;

import com.example.demo.dto.CustomerDTO;
import com.example.demo.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginatedCustomerDTO implements SuperDTO {
    private List<CustomerDTO> list;
    private long dataCount;


}
