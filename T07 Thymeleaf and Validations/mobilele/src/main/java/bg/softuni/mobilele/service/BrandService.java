package bg.softuni.mobilele.service;

import bg.softuni.mobilele.model.dto.BrandDTO;
import bg.softuni.mobilele.model.dto.ModelDTO;
import bg.softuni.mobilele.model.entity.BrandEntity;
import bg.softuni.mobilele.model.entity.ModelEntity;
import bg.softuni.mobilele.repository.BrandRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandService {
    private final BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public List<BrandDTO> getAllBrands() {
         return brandRepository
                 .findAll()
                 .stream()
                 .map(this::mapBrand)
                 .collect(Collectors.toList());
    }

    private BrandDTO mapBrand(BrandEntity brandEntity) {
        List<ModelDTO> models = brandEntity
                .getModels()
                .stream()
                .map(this::mapModel)
                .toList();

        BrandDTO result = new BrandDTO();
        result.setModels(models);
        result.setName(brandEntity.getName());

        return result;
    }

    private ModelDTO mapModel(ModelEntity modelEntity) {
      ModelDTO modelDTO = new ModelDTO();
      modelDTO.setId(modelEntity.getId());
      modelDTO.setName(modelEntity.getName());

      return modelDTO;
    }
}
