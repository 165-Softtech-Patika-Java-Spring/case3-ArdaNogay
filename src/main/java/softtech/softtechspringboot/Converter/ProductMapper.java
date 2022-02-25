package softtech.softtechspringboot.Converter;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import softtech.softtechspringboot.Dto.ProductPriceDto;
import softtech.softtechspringboot.Dto.ProductSaveRequestDto;
import softtech.softtechspringboot.Entity.Product;

import java.util.List;
import java.util.Optional;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductSaveRequestDto convertToProductSaveRequestDto(Optional<Product> product);
    ProductSaveRequestDto convertToProductSaveRequestDto(Product product);

    List<ProductSaveRequestDto> convertToProductSaveRequestDtoList(List<Product> productList);

    Product convertToProduct(ProductSaveRequestDto productSaveRequestDto);
}
