package softtech.softtechspringboot.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import softtech.softtechspringboot.Converter.ProductMapper;
import softtech.softtechspringboot.Dto.ProductPriceDto;
import softtech.softtechspringboot.Dto.ProductSaveRequestDto;
import softtech.softtechspringboot.Entity.Product;
import softtech.softtechspringboot.Service.EntityService.ProductEntityService;


import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductEntityService productEntityService;

    public List<ProductSaveRequestDto> findAll() {
        List<Product> productList = productEntityService.findAll();
        List<ProductSaveRequestDto> productSaveRequestDtoList = ProductMapper.INSTANCE.convertToProductSaveRequestDtoList(productList);
        return productSaveRequestDtoList;
    }

    public ProductSaveRequestDto findById(Long id){
        Optional<Product> product = productEntityService.findById(id);
        ProductSaveRequestDto productSaveRequestDto = ProductMapper.INSTANCE.convertToProductSaveRequestDto(product);
        return  productSaveRequestDto;
    }

    public ProductSaveRequestDto save(ProductSaveRequestDto productSaveRequestDto){
        Product product = ProductMapper.INSTANCE.convertToProduct(productSaveRequestDto);
        product = productEntityService.save(product);
        ProductSaveRequestDto willBeReturnedUserSaveRequestDto = ProductMapper.INSTANCE.convertToProductSaveRequestDto(product);
        return willBeReturnedUserSaveRequestDto;
    }

    public ProductSaveRequestDto update(Long id, ProductPriceDto productPriceDto) {
        Product product = productEntityService.getById(id);
        product.setPrice(productPriceDto.getPrice());
        productEntityService.save(product);
        ProductSaveRequestDto productSaveRequestDto = ProductMapper.INSTANCE.convertToProductSaveRequestDto(product);
        return productSaveRequestDto;
    }

    public void delete(Long id){
        Product product = productEntityService.getById(id);
        productEntityService.delete(product);
    }
}
