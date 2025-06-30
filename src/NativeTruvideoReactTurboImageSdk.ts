import type { TurboModule } from 'react-native';
import { TurboModuleRegistry } from 'react-native';

export interface Spec extends TurboModule {
  launchImageEdit(inputPath: string, outputPath: string): Promise<string>;
  getFilePath(fileName: string): Promise<string>;
  getInfo(imagePath: string): Promise<string>;
  edit(
    imagePath: string,
    resultPath: string,
    rotation: string,
    cropInformation: string,
    horizontalFlip: boolean,
    verticalFlip: boolean,
    width: number,
    height: number,
    outputFormat: string,
    compressionQuality: number
  ): Promise<string>;
}

export default TurboModuleRegistry.getEnforcing<Spec>(
  'TruvideoReactTurboImageSdk'
);
