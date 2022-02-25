package softtech.softtechspringboot.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import softtech.softtechspringboot.Dto.ProductPriceDto;
import softtech.softtechspringboot.Dto.ProductSaveRequestDto;
import softtech.softtechspringboot.Service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity getAll(){

        List<ProductSaveRequestDto> productSaveRequestDtoList = productService.findAll();
        return ResponseEntity.ok(productSaveRequestDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable("id") Long id){

        ProductSaveRequestDto productSaveRequestDto = productService.findById(id);
        return ResponseEntity.ok(productSaveRequestDto);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody ProductSaveRequestDto productSaveRequestDto){

        productSaveRequestDto = productService.save(productSaveRequestDto);
        return ResponseEntity.ok(productSaveRequestDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody ProductPriceDto productPriceDto){

        ProductSaveRequestDto productSaveRequestDto = productService.update(id,productPriceDto);
        return ResponseEntity.ok(productPriceDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){

        productService.delete(id);
        return ResponseEntity.ok(Void.TYPE);
    }
}
